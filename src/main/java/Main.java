import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        AttackingRooks solver = new AttackingRooks();
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            int n = Integer.parseInt(line);
            String[] board = new String[n];
            for (int i = 0; i < n; i++) {
                board[i] = br.readLine().trim();
            }
            out.append(solver.maxRooks(board)).append('\n');
        }
        System.out.print(out);
    }
}
