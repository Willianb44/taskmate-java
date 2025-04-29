import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public TaskManager() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Añadir tarea\n2. Mostrar tareas\n3. Marcar tarea como completada\n4. Eliminar tarea\n5. Salir");
            System.out.print("Elige una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void addTask() {
        System.out.print("Escribe la descripción de la tarea: ");
        String desc = scanner.nextLine();
        tasks.add(new Task(desc));
        System.out.println("Tarea añadida.");
    }

    private void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void completeTask() {
        showTasks();
        System.out.println("== LISTADO DE TAREAS ==");
        int num = scanner.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.get(num - 1).markCompleted();
            System.out.println("Tarea completada.");
        } else {
            System.out.println("Número inválido.");
        }
    }

    private void removeTask() {
        showTasks();
        System.out.print("Número de tarea a eliminar: ");
        int num = scanner.nextInt();
        if (num > 0 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Número inválido.");
        }
    }
}
