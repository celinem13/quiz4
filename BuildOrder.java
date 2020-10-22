import java.util.Arrays;

public class BuildOrder {
    static  String[] completed = new String[0];
    static int completedI = 0;
    public static void main(String[] args) throws Exception {
        System.out.println("Question 2:");

        String[] p = new String[]{"a", "b", "c", "d", "e", "f"};
        String[][] d = new String[][] {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"},
        };

        buildOrder(p, d);

        System.out.println("Valid Build Order: " + Arrays.toString(completed));
    }

    static void buildOrder (String[] projects, String[][] dependencies) throws Exception
    {

        completed = new String[projects.length];
        boolean possible = false;

        boolean conditions;

        // Check for projects that have no dependencies
        for (int i = 0; i < projects.length; i++)
        {
            conditions = false;
            for (int j = 0; j < dependencies.length; j++)
                if (projects[i] == dependencies[j][1])
                {
                    conditions = true;
                    break;
                }

            if (!conditions)
            {
                completed[completedI] = projects[i];
                completedI++;
                possible = true;
            }
        }

        // If there are no projects that do not have a dependency, throw an exception
        if (!possible)
            throw new Exception("Error: No Valid Build Order");

        findRequ(dependencies, completed[1]);

        // If completed is not full, throw an exception
        if (completedI < completed.length)
            throw new Exception("Error: No Valid Build Order");
    }

    static void findRequ(String[][] d, String target) {
        for (int i = 0; i < d.length; i++) {
            if (d[i][0] == target) {
                d[i][0] = null;

                int onlyRequ = 0;
                for (int j = 0; j < d.length; j++)
                    if (d[i][1] == d[j][1])
                        onlyRequ++;

                if (onlyRequ == 1) {
                    completed[completedI] = d[i][1];
                    completedI++;
                }

                findRequ(d, d[i][1]);

                d[i][1] = null;
            }
        }
    }
}
