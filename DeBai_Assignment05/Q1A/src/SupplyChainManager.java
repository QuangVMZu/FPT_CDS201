
import java.io.File;
import java.io.RandomAccessFile;

class InventoryList {

    Node head, tail;

    InventoryList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void loadDataInventory(int k) {
        try {
            clear();

            File dataFile = new File("data.txt");
            if (!dataFile.exists()) {
                System.out.println("File data.txt không tồn tại.");
                return;
            }

            try {
                String line1 = Lib.readLineToStr("data.txt", k);
                String line2 = Lib.readLineToStr("data.txt", k + 1);
                String line3 = Lib.readLineToStr("data.txt", k + 2);

                if (line1 == null || line2 == null || line3 == null) {
                    System.out.println("Không thể đọc đủ dữ liệu từ file data.txt.");
                    return;
                }

                String[] ids = line1.trim().split("\\s+");
                String[] names = line2.trim().split("\\s+");
                String[] quantityStrs = line3.trim().split("\\s+");

                if (ids.length == 0 || names.length == 0 || quantityStrs.length == 0) {
                    System.out.println("Dữ liệu trong file data.txt trống.");
                    return;
                }

                int[] quantities = new int[quantityStrs.length];
                for (int i = 0; i < quantityStrs.length; i++) {
                    try {
                        quantities[i] = Integer.parseInt(quantityStrs[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Định dạng số lượng không hợp lệ: " + quantityStrs[i]);
                        return;
                    }
                }

                int n = Math.min(ids.length, Math.min(names.length, quantities.length));
                for (int j = 0; j < n; j++) {
                    addLast(ids[j], names[j], quantities[j]);
                }
                System.out.println("Đã nạp dữ liệu kho hàng từ file thành công: " + n + " mục.");
            } catch (Exception e) {
                System.out.println("Lỗi khi đọc dữ liệu kho hàng: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Lỗi nghiêm trọng trong quá trình nạp dữ liệu kho hàng: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void addLast(String id, String name, int quantity) {
        if (quantity > 0) {
            Product newProduct = new Product(id, name, quantity);
            Node newNode = new Node(newProduct);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
    }
}

class ShippingList {

    Node head;

    ShippingList() {
        head = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = null;
    }

    void loadDataShipping(int k) {
        try {
            clear();

            File dataFile = new File("data.txt");
            if (!dataFile.exists()) {
                System.out.println("File data.txt không tồn tại.");
                return;
            }

            try {
                String[] ids = Lib.readLineToStrArray("data.txt", k + 3);
                String[] quantityStr = Lib.readLineToStrArray("data.txt", k + 4);

                if (ids == null || quantityStr == null) {
                    System.out.println("Không thể đọc đủ dữ liệu vận chuyển từ file data.txt.");
                    return;
                }

                int[] quantities = new int[quantityStr.length];
                for (int i = 0; i < quantityStr.length; i++) {
                    try {
                        quantities[i] = Integer.parseInt(quantityStr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Định dạng số lượng vận chuyển không hợp lệ ở vị trí " + i + ": " + quantityStr[i]);
                        return;
                    }
                }

                int n = Math.min(ids.length, quantities.length);
                for (int j = 0; j < n; j++) {
                    push(ids[j], quantities[j]); // Sử dụng push thay vì insert
                }
                System.out.println("Đã nạp dữ liệu vận chuyển từ file thành công: " + n + " mục.");
            } catch (Exception e) {
                System.out.println("Lỗi khi đọc dữ liệu vận chuyển: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Lỗi nghiêm trọng trong quá trình nạp dữ liệu vận chuyển: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void push(String id, int quantity) {
        if (quantity > 0) {
            Product newProduct = new Product(id, quantity);
            Node newNode = new Node(newProduct);
            if (isEmpty()) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }
    }

    Product pop() {
        if (isEmpty()) {
            return null;
        } else {
            Product p = head.info;
            head = head.next;
            return p;
        }
    }

    Product peek() {
        if (isEmpty()) {
            return null;
        } else {
            return head.info;
        }
    }
}

class SupplyChainManager {

    InventoryList warehouseItems = new InventoryList();
    ShippingList shippingQueue = new ShippingList();

    SupplyChainManager() {
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = warehouseItems.head;
        f.writeBytes("Warehouse Inventory: ");
        while (p != null) {
            fvisit(p, f); // Write information of node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
        f.writeBytes("Shipping List: ");
        p = shippingQueue.head;
        if (p == null) {
            f.writeBytes("Empty");
        }
        while (p != null) {
            f.writeBytes("(" + p.info.getId() + "," + p.info.getQuantity() + ") ");
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void load(int k) throws Exception // do not edit this function
    {
        warehouseItems.loadDataInventory(k);
        shippingQueue.loadDataShipping(k);
    }

    // ===========================================================================
    // =======YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
    // ===========================================================================
    void f1() throws Exception {
        load(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        f.close();
    }

    int updateInventory(Product request) {
        Node current = warehouseItems.head;
        int total = 0;

        while (current != null) {
            Product p = current.info;
            if (p.getId().equalsIgnoreCase(request.getId())) {
                    int quantityToSell = request.getQuantity();

                    total = quantityToSell;

                    p.setQuantity(p.getQuantity() - quantityToSell);
                }
            current = current.next;
        }
        return total;
    }

    void f2() throws Exception {
        load(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        // Lấy một phần tử từ stack 
        Product request = shippingQueue.pop();
        if (request != null) {
            updateInventory(request);
        }
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f3() throws Exception {
        load(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */
        while (!shippingQueue.isEmpty()) {
            Product request = shippingQueue.pop();
            if (request != null) {
                updateInventory(request);
            }
        }
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    void f4() throws Exception {
        load(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);

        int totalShipped = 0;
        // ------------------------------------------------------------------------------------
        /*
         * You must keep statements pre-given in this function.
         * Your task is to insert statements here, just after this comment,
         * to complete the question in the exam paper.
         */

        while (!shippingQueue.isEmpty()) {
            Product request = shippingQueue.pop();
            if (request != null) {
                totalShipped += updateInventory(request);
            }
        }
        // ------------------------------------------------------------------------------------
        f.writeBytes("Total Shipped Quantity: " + totalShipped + " ");
        f.close();
    }
}
