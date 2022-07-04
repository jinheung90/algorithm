#include <string>
#include <vector>

using namespace std;
//정수 삼각형
int solution(vector<vector<int>> triangle) {


    int ySize = triangle.size();
    int xSize = 0;

    int x1;
    int x2;
 
    for(int y = ySize - 1; y >= 1; --y) {
        xSize = triangle[y].size();

        
        for(int x = 0; x < xSize - 1;  ++x) { 
            
            x1 = triangle[y][x]; // 내 위치
           
            x2= triangle[y][x + 1];
 
            if(x1> x2 ) {
                triangle[y-1][x] += x1;
            }
            else {
                triangle[y-1][x] += x2;
            }
        }
  
        
    }
    
    return  triangle[0][0];
}