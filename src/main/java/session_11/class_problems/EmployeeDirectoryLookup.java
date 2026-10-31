package session_11.class_problems;

import java.util.HashMap;
import java.util.Map;

class EmployeeRecord {
    String id;
    String department;

    public EmployeeRecord(String id, String department) {
        this.id = id;
        this.department = department;
    }
}

public class EmployeeDirectoryLookup {
    public static Map<String, String> buildLookup(EmployeeRecord[] records) {
        Map<String, String> lookup = new HashMap<>();
        for (EmployeeRecord rec : records) {
            lookup.put(rec.id, rec.department);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        EmployeeRecord[] records = {
            new EmployeeRecord("E245", "Finance"),
            new EmployeeRecord("E110", "Engineering"),
            new EmployeeRecord("E390", "Marketing"),
            new EmployeeRecord("E101", "Engineering")
        };

        Map<String, String> lookup = buildLookup(records);

        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
