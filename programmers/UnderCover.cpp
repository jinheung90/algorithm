#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;

// 위장
int solution(vector<vector<string>> clothes) {

	map<string, vector<string>*> map;
	int size = clothes.size();
	std::map<string, vector<string>*>::iterator it;
	for (int i = 0; i < size; ++i) {
		it = map.find(clothes[i][1]);
		if (it == map.end()) {
       
			vector<string>* vValPtr = new vector<string>();
			vValPtr->push_back(clothes[i][0]);
			map.insert(make_pair(clothes[i][1], vValPtr));
		}
		else {
			it->second->push_back(clothes[i][0]);
		}

	}
	int count = 1;

	for (it = map.begin(); it != map.end(); it++) {
        
        cout << it->first << endl;
        for(int i =0; i < it->second->size(); ++i) {
            cout << it->second->begin()[i] << endl;
        }
        
		count *= (it->second->size() + 1);
        cout << count << endl;
	}

    return --count;
}