import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // default test         test(1000,100,65,25,5, "test ilosci");

        // test ilosci procesow

        test(100,100,65,25,5, "test -1");
        test(1000,100,65,25,5, "test 0");
        //test(10000,100,65,25,5,"test ilosci procesow3");

        // test ilosci procesorow
        test(1000,50,65,25,5, "test 1");
        test(1000,75,65,25,5, "test 2");
        test(1000,100,65,25,5, "test 3");
        System.out.println("_________________________________________________________________");
        test(1000,50,65,25,5, "test 4");
        test(1000,75,65,25,5, "test 5");
        test(1000,150,65,25,5, "test 6");
            // test minL
        test(1000,50,65,5,5, "test 7");
        test(1000,50,65,25,5, "test 8");
        test(1000,50,65,50,5, "test 9");

        // test max

        test(1000,50,30,10,5, "test ilosci procesorow10");
        test(1000,50,50,10,5, "test ilosci procesoro11");


    }

    private static void test(int aPrs, int aPcs, int maxL, int minL, int aT, String stringG) {
        int amountProcesses = aPrs;
        int amountProcessors = aPcs;    //N
        int maxLoad = maxL;             //p
        int amountTrial = aT;          //z
        int minLoad = minL;             //r

        int[] sZap = new int[3], sMigr = new int[3]; double[] sSOb = new double[3], sSod = new double[3];

        int testsAmount = 100;

        for (int k = 0; k<testsAmount; k++){
            ArrayList<Process> processes = generateProcesses(amountProcesses);
            Algorithms algorithms = new Algorithms(maxLoad, amountTrial, minLoad);
            for (int i = 1; i <= 3; i++) {
                ArrayList<Processor> processors = generateProcessors(amountProcessors);
                ArrayList<Process> copyProcesses = copyProcesses(processes);
                ArrayList results = algorithms.simulate(copyProcesses, processors, i);
                sZap[i-1] += (int) results.get(2); sMigr[i-1] += (int) results.get(3);
                sSOb[i-1] += (double) results.get(0); sSod[i-1] += (double) results.get(1);
                /*
                System.out.println("---------------");
                System.out.println("Wariant " + i);
                System.out.printf("Srednie obciazenie: %.2f%s\n", results.get(0), "%");
                System.out.printf("Srednie Odchylenie: %.2f%s\n", results.get(1), "%");
                System.out.println("Zapytania: " + results.get(2));
                System.out.println("Migracje:  " + results.get(3));


                 */

            }
        }
        System.out.println("\n\n\n\n\n" + stringG + "\n\n");
        for (int i = 0; i < 3; i++){
            System.out.println("---------------");
            System.out.println("Wariant " + (i+1));
            System.out.printf("Srednie obciazenie: %.2f%s\n", (sSOb[i]/testsAmount), "%");
            System.out.printf("Srednie Odchylenie: %.2f%s\n", sSod[i]/testsAmount, "%");
            System.out.println("Zapytania: " + sZap[i]/testsAmount);
            System.out.println("Migracje:  " + sMigr[i]/testsAmount);
        }
    }


    private static ArrayList<Process> generateProcesses(int amount) {
        ArrayList<Process> processes = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            processes.add(new Process());
        }
        return processes;
    }

    private static ArrayList<Process> copyProcesses(ArrayList<Process> processes) {
        ArrayList<Process> processes2 = new ArrayList<>();
        for (Process process : processes) {
            processes2.add(new Process(process.loadCPU, process.amountTasks));
        }
        return processes2;
    }

    private static ArrayList<Processor> generateProcessors(int amount) {
        ArrayList<Processor> processors = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            processors.add(new Processor());
        }
        return processors;
    }

}