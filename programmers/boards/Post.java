package boards;



public class Post {
    private Long userId;
    private String context;
    private String subject;


    public Post(Long userId, String context, String subject) {
        this.userId = userId;
        this.context = context;
        this.subject = subject;
    }


    public Long getUserId() {
        return userId;
    }

    public String getContext() {
        return context;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "{" +
                "\"userId\"" +
                ":" +
                userId +
                "," +
                "\"context\"" +
                ":" +
                "\"" + context + "\"" +
                "," +
                "\"subject\"" +
                ":" +
                "\"" + subject + "\"" +
                "}";
    }
}
