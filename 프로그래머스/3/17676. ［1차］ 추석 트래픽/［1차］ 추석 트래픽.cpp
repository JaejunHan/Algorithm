#include <string>
#include <vector>
#include <unordered_map>
#include <sstream>
#include <iostream>
#include <algorithm>

using namespace std;

int solution(vector<string> lines) {
    unordered_map<int, vector<pair<int, bool>>> mp;
    for (auto line: lines) {   
        int year, month, day, hour, minute, second, millisecond;
        char delimiter;
        double duration;

        istringstream iss(line);
        iss >> year >> delimiter >> month >> delimiter >> day;
        iss.ignore(1); // skip the space
        iss >> hour >> delimiter >> minute >> delimiter >> second >> delimiter >> millisecond;
        iss.ignore(1); // skip the space
        iss >> duration;

        int sum = year * 2 + month * 3 + day * 5;

        int total_milliseconds = hour * 3600 * 1000 + minute * 60 * 1000 + second * 1000 + millisecond;
        int duration_milliseconds = (int) (duration * 1000);
        int start_milliseconds = total_milliseconds - duration_milliseconds + 1;
        int end_milliseconds = total_milliseconds;
        mp[sum].push_back({start_milliseconds, false});
        mp[sum].push_back({end_milliseconds+999, true});
    }
    
    int answer = 0;
    for (auto ele: mp) {
        int cnt = 0;
        vector<pair<int, bool>> tmp = ele.second;
        sort(tmp.begin(), tmp.end());
        int a= 1;
        for (auto ele2 : tmp) {
            if (!ele2.second) {
                cnt += 1;
                answer = max(answer, cnt);
            } else {
                cnt -= 1;
                answer = max(answer, cnt);
            }
        }
    }

    return answer;
}
