
#include <string>
#include <vector>
#include<algorithm>
using namespace std;
// 구명보트
int solution(vector<int> people, int limit) {
     int count = 0; 
    int size = people.size();

    sort(people.begin(), people.end()); //1
    int endIndex = size;
    int j;
    for (int i = 0; i < endIndex; ++i) {

        count++;
        for (j = endIndex - 1; j > i; --j) {

            if (people[i] + people[j] <= limit) {

                endIndex = j;

                break;
            }
             count++;
        }
        endIndex = j;

    }

    return count;
}
