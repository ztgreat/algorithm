package com.github.ztgreat.dfs.leetcode_690;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<Integer, Employee>(employees.size());

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map,id);

    }

    public int dfs(Map<Integer, Employee> map, int id) {

        Employee employee = map.get(id);
        if (employee.subordinates == null || employee.subordinates.isEmpty()) {
            return employee.importance;
        }
        int res = 0;
        for (Integer i : employee.subordinates) {
            res += dfs(map, i);
        }
        return res + employee.importance;
    }
}