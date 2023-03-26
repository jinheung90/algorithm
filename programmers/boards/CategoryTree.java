package boards;

import java.lang.reflect.Array;
import java.util.*;
// 구조는 트리구조를 쓰긴 하는데 id는 일단 이름으로 함


public class CategoryTree {
    private String id;
    private String name;

    private HashMap<String, CategoryTree> childKeyId;
    private boolean isLeaf;
    private List<Post> posts;

    private static final CategoryTree anonymousPosts = new CategoryTree("anonymous", true);
    private static final String anonymousPostKey = UUID.randomUUID().toString();
    private static final String anonymousPostName = "anonymous";
    public static String getAnonymousPostKey() {
        return anonymousPostKey;
    }
    public CategoryTree(String name, boolean isLeaf) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.childKeyId = new HashMap<>();
        this.isLeaf = isLeaf;
        this.posts = new ArrayList<>();
    }

    private void addPost(Post post) {
        this.posts.add(post);
    }
    public void addCategoryName(String name, String parent) {

        if(this.name.equals(parent)) {


            CategoryTree categoryTree;

            if(this.posts.size() > 0) {
                System.out.println("can not save category and parent has posts");
                return;
            }
            this.isLeaf = false;
            if(anonymousPostName.equals(name)) {
                categoryTree = anonymousPosts;
            } else {
                categoryTree = new CategoryTree(name, true);
            }

            childKeyId.put(categoryTree.getId(),categoryTree);
            return;
        }
        childKeyId.forEach((key, value) -> value.addCategoryName(name, parent));
    }

    public void addCategoryById(String name, String pId) {

        if(this.id.equals(pId)) {
            CategoryTree categoryTree;
            if(this.posts.size() > 0) {
                System.out.println("can not save category and parent has posts");
                return;
            }
            this.isLeaf = false;
            if(anonymousPostKey.equals(pId)) {
                categoryTree = anonymousPosts;
            } else {
                categoryTree = new CategoryTree(name, true);
            }
            childKeyId.put(categoryTree.getId(),categoryTree);
            return;
        }

        childKeyId.forEach((key, value) -> value.addCategoryById(name, pId));
    }

    public HashSet<CategoryTree> getCategoryTreesByName(String name) {
        HashSet<CategoryTree> categoryTrees = new HashSet<>();
        if(name.equals(anonymousPostName)) {
            categoryTrees.add(anonymousPosts);
            return categoryTrees;
        }
        getCategoryTreesByName(name, categoryTrees, false);

        return categoryTrees;
    }


    private void getCategoryTreesById(String id, HashSet<CategoryTree> result, boolean saveMode) {

        if(isLeaf && saveMode) {
            result.add(this);
        }
        if(this.id.equals(id)) {

            if(isLeaf) {

                result.add(this);
            }
            childKeyId.forEach((key, value) -> value. getCategoryTreesByName(id, result, true));
            return;
        } else {
            childKeyId.forEach((key, value) -> value. getCategoryTreesByName(id, result, saveMode));
            return;
        }

    }

    public HashSet<CategoryTree> getCategoryTreesById(String id) {
        HashSet<CategoryTree> categoryTrees = new HashSet<>();
        if(id.equals(anonymousPostKey)) {
            categoryTrees.add(anonymousPosts);
            return categoryTrees;
        }
        getCategoryTreesByName(id, categoryTrees, false);

        return categoryTrees;
    }

    private void getCategoryTreesByName(String name, HashSet<CategoryTree> result, boolean saveMode) {

        if(isLeaf && saveMode) {
            result.add(this);
        }
        if(this.name.equals(name)) {

            if(isLeaf) {

                result.add(this);
            }
            childKeyId.forEach((key, value) -> value. getCategoryTreesByName(name, result, true));
            return;
        } else {
            childKeyId.forEach((key, value) -> value. getCategoryTreesByName(name, result, saveMode));
            return;
        }

    }


    public void addPostByCategoryName(String name, Post post) {
        if(name.equals(anonymousPostKey)) {
            anonymousPosts.addPost(post);
            return;
        }
        if(name.equals(this.name)) {
            this.addPost(post);
            return;
        }
        childKeyId.forEach((key, value) -> value.addPostByCategoryName(name, post));
    }

    public String getName() {
        return name;
    }


    public HashMap<String, CategoryTree> getChild() {
        return childKeyId;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
//        stringBuilder.append("\"data\" : {");
        stringBuilder.append("\"name\" : " + "\"" + name + "\"");
        stringBuilder.append(",");
        stringBuilder.append("\"id\" : " + "\"" + id + "\"");
        stringBuilder.append(",");
        stringBuilder.append("\"posts\" : ");
        stringBuilder.append(postsJson());
        stringBuilder.append("}");
//        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String getJsonDataByName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"data\" : [");
        HashSet<CategoryTree> trees = this.getCategoryTreesByName(name);

        for (CategoryTree categoryTree : trees) {
            stringBuilder.append(categoryTree.toString());
            stringBuilder.append(",");
        }
        int last = stringBuilder.lastIndexOf(",");
        if(last != -1) stringBuilder.deleteCharAt(last);
        stringBuilder.append("]");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String getJsonDataById(String id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"data\" : [");
        HashSet<CategoryTree> trees = this.getCategoryTreesById(name);

        for (CategoryTree categoryTree : trees) {
            stringBuilder.append(categoryTree.toString());
            stringBuilder.append(",");
        }
        int last = stringBuilder.lastIndexOf(",");
        if(last != -1) stringBuilder.deleteCharAt(last);
        stringBuilder.append("]");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public String postsJson() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if(isLeaf) {
            for (int i = 0; i < posts.size(); i++) {
                stringBuilder.append(posts.get(i).toString());
                stringBuilder.append(",");
            }
            int last = stringBuilder.lastIndexOf(",");
            if(last != -1) stringBuilder.deleteCharAt(last);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CategoryTree)) {
            return false;
        }
        return this.id.equals(((CategoryTree) obj).getId());
    }
}
