#include <iostream>
#include <vector>
#include <algorithm>
#include <ctime>
using namespace std;


// 행렬 영역 테스트 코드 완료
void stretch(int* count, int **matrix, int posX, int posY , int sizeOfMatrix) {
    if (matrix[posY][posX] == 0) {
        return;
    }

    (*count)++;
    matrix[posY][posX] = 0;
    if (posX > 0) {
        stretch(count, matrix, posX - 1 , posY, sizeOfMatrix);
    }

    if (posX < sizeOfMatrix) {
        stretch(count, matrix, posX + 1, posY, sizeOfMatrix );
    }

    if (posY > 0) {
        stretch(count, matrix, posX, posY - 1, sizeOfMatrix);
    }

    if (posY < sizeOfMatrix) {
        stretch(count, matrix, posX, posY + 1, sizeOfMatrix);
    }   
}

int tester(int *** matrix) {
   
    int size = rand() % 10 + 1;
    cout << size << endl;
    cout << endl;
    (*matrix) = new int* [size];

    for (int y = 0; y < size; ++y) {
        (*matrix)[y] = new int[size];
    }

   

    for (int y = 0; y < size; ++y) {
        for (int x = 0; x < size; ++x) {
            (*matrix)[y][x] = rand() % 2;
        }
    }
    return size;
}

void printer(int size, int*** matrix) {
    for (int y = 0; y < size; ++y) {
        for (int x = 0; x < size; ++x) {
            cout << (*matrix)[y][x] << "  ";
        }

       cout << endl;

      
    }
    cout << endl;
}

int main()
{   
    srand((unsigned int)time(0));
    
    int** matrix;
    int sizeOfMatrix = tester(&matrix);
    printer(sizeOfMatrix, &matrix);

   
    vector<int> rs;
    int* count = new int(0);
    for (int y = 0; y < sizeOfMatrix; ++y) {

        for (int x = 0; x < sizeOfMatrix; ++x) {
            if (matrix[y][x] == 1) {
                
                stretch(count, matrix, x, y, sizeOfMatrix - 1);
                //cout << x << " " << y << " " << endl;
                rs.push_back(*count);
                *count = 0;
 
            }
        }

    }
    delete count;
    int size = rs.size();


    if (rs.empty()) {
        cout << 0 << endl;
    }
    else {
        sort(rs.begin(), rs.end());
        cout << size << endl;
        cout << rs[0];

        for (int i = 1; i < size; ++i) {
            cout << " " << rs[i];
        }
        cout << endl;
    }
}
