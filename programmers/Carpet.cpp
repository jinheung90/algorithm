#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
        int xBrown;
        int xYellow;
        int yBrown;
        int yYellow;
        int area = brown + yellow;
        vector<int> answer;

        for (xBrown = 3; xBrown <= area - 3; ++xBrown) {
            if (xBrown * (area -xBrown) == area) {
                if ((xBrown - 2) * (area -xBrown - 2) == yellow) {
                    answer.push_back(xBrown);
                    answer.push_back(area -xBrown);
                    return answer;
                }
            
            }
        
    }
    return answer;
}