public class TaskManagement {
    private Node head;
    private Node tail;
    private int size;

    public TaskManagement() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    // Search for a task by ID
    public Task searchTaskById(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.getTask().getTaskId().equals(taskId)) {
                return current.getTask();
            }
            current = current.getNext();
        }
        return null; // Task not found
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("No tasks to display.");
        } else {
            while (current != null) {
                System.out.println(current.getTask());
                current = current.getNext();
            }
        }
    }

    // Delete a task by ID
    public void deleteTaskById(String taskId) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.getTask().getTaskId().equals(taskId)) {
                if (previous == null) { // Deleting head
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                if (current == tail) { // Deleting tail
                    tail = previous;
                }
                size--;
                System.out.println("Task with ID " + taskId + " deleted.");
                return;
            }
            previous = current;
            current = current.getNext();
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }
}
