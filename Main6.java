import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Khởi tạo mảng và nhập kích thước
        System.out.print("Nhập kích thước mảng: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Kích thước mảng không hợp lệ!");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 2. Sắp xếp mảng giảm dần bằng thuật toán Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) { // Tìm phần tử lớn nhất để đưa lên đầu (giảm dần)
                    maxIdx = j;
                }
            }
            // Hoán đổi
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;
        }

        // Hiển thị mảng đã sắp xếp
        System.out.print("Mảng sau khi sắp xếp theo thứ tự giảm dần: [");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + (i < n - 1 ? ", " : ""));
        }
        System.out.println("]");

        // 3. Nhập số cần tìm
        System.out.print("Nhập số cần tìm: ");
        int target = scanner.nextInt();

        // --- Tìm kiếm tuyến tính ---
        int linearIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                linearIndex = i;
                break; // Tìm thấy vị trí đầu tiên thì dừng
            }
        }

        if (linearIndex != -1) {
            System.out.println("Tìm kiếm tuyến tính: Phần tử " + target + " tìm thấy tại chỉ số: " + linearIndex);
        } else {
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy phần tử " + target + " trong mảng");
        }

        // --- Tìm kiếm nhị phân (trên mảng ĐÃ SẮP XẾP GIẢM DẦN) ---
        int binaryIndex = -1;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                binaryIndex = mid;
                break;
            } else if (arr[mid] < target) {
                // Vì mảng giảm dần nên nếu phần tử ở giữa NHỎ HƠN target thì target nằm ở bên TRÁI (phần lớn hơn)
                right = mid - 1;
            } else {
                // Nếu phần tử ở giữa LỚN HƠN target thì target nằm ở bên PHẢI (phần nhỏ hơn)
                left = mid + 1;
            }
        }

        if (binaryIndex != -1) {
            System.out.println("Tìm kiếm nhị phân: Phần tử " + target + " tìm thấy tại chỉ số: " + binaryIndex);
        } else {
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy phần tử " + target + " trong mảng");
        }

        scanner.close();
    }
}