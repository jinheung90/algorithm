

// 2019 카카오 개발자 겨울 인턴 문제
#include <string>
#include <vector>
#include <stack>
using namespace std;



int solution(vector<vector<int>> board, vector<int> moves) {

    stack<int> iStack;
    int count = 0;
    for (int i = 0; i < moves.size(); ++i) {
   
        for (int y = 0; y < board.size(); ++y) {
           
            
            if (board[y][moves[i] - 1] == 0) continue;
            if (iStack.empty()) {

                iStack.push(board[y][moves[i] - 1]);
                board[y][moves[i] - 1] = 0;
                break;
            }


            if (iStack.top() == board[y][moves[i] - 1])
            {
          
                count += 2;
                iStack.pop();
                    board[y][moves[i] - 1] = 0;
                break;
            }
            else {
                iStack.push(board[y][moves[i] - 1]);
                 board[y][moves[i] - 1] = 0;
                break;
            }
            
                
        }
    }
    return count;
}