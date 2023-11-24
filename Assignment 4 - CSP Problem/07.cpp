#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>
using namespace std;

unordered_map<char, int> charToValue;

int calculateString(const string& s) {
    int val = 0;

    for (char ch : s) {
        val = val * 10 + charToValue[ch];
    }

    return val;
}

bool solveCryptarithmetic(string s1, string s2, string s3, string chars, vector<bool>& used) {
    if (chars.empty()) {
        int val1 = calculateString(s1);
        int val2 = calculateString(s2);
        int val3 = calculateString(s3);
        return (val1 + val2 == val3);
    }

    for (int i = 0; i < 10; i++) {
        char ch = chars.back();
        if (i == 0 && (ch == s1[0] || ch == s2[0] || ch == s3[0]))
            continue;
        if (!used[i]) {
            charToValue[ch] = i;
            used[i] = true;
            chars.pop_back();
            if (solveCryptarithmetic(s1, s2, s3, chars, used))
                return true;
            chars.push_back(ch);
            used[i] = false;
        }
    }

    return false;
}

bool solve(string s1, string s2, string s3) {
    string chars = s1 + s2 + s3;
    sort(chars.begin(), chars.end());
    chars.erase(unique(chars.begin(), chars.end()), chars.end());

    if (chars.length() > 10) {
        return false;
    }

    vector<bool> used(10, false); // Initialize used vector
    return solveCryptarithmetic(s1, s2, s3, chars, used);
}

int main() {
 
    string s1 = "MAC";
    string s2 = "MAAR";
    string s3 = "JOCKO";

    if (solve(s1, s2, s3)) {
        cout << "Solution found:" << endl;
        for (const auto& pair : charToValue) {
            cout << " " << pair.first << " = " << pair.second << endl;
        }
    } else {
        cout << "No solution" << endl;
    }

    return 0;
}

