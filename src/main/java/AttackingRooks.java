import java.util.Arrays;

public class AttackingRooks {

    public int maxRooks(String[] board) {
        int n = board.length;
        int[][] rowSeg = new int[n][n];
        int[][] colSeg = new int[n][n];

        int rowCount = assignRowSegments(board, rowSeg);
        int colCount = assignColSegments(board, colSeg);

        int[] deg = new int[rowCount];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) == '.') {
                    deg[rowSeg[i][j]]++;
                }
            }
        }

        int[][] adj = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            adj[i] = new int[deg[i]];
            deg[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i].charAt(j) == '.') {
                    int r = rowSeg[i][j];
                    adj[r][deg[r]++] = colSeg[i][j];
                }
            }
        }

        int[] matchCol = new int[colCount];
        Arrays.fill(matchCol, -1);
        int[] vis = new int[colCount];
        int stamp = 1;
        int matching = 0;
        for (int u = 0; u < rowCount; u++) {
            if (dfs(u, adj, matchCol, vis, stamp)) {
                matching++;
            }
            stamp++;
        }
        return matching;
    }

    private int assignRowSegments(String[] board, int[][] rowSeg) {
        int n = board.length;
        int id = 0;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n) {
                if (board[i].charAt(j) == 'X') {
                    j++;
                    continue;
                }
                int current = id++;
                while (j < n && board[i].charAt(j) != 'X') {
                    rowSeg[i][j] = current;
                    j++;
                }
            }
        }
        return id;
    }

    private int assignColSegments(String[] board, int[][] colSeg) {
        int n = board.length;
        int id = 0;
        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < n) {
                if (board[i].charAt(j) == 'X') {
                    i++;
                    continue;
                }
                int current = id++;
                while (i < n && board[i].charAt(j) != 'X') {
                    colSeg[i][j] = current;
                    i++;
                }
            }
        }
        return id;
    }

    private boolean dfs(int u, int[][] adj, int[] matchCol, int[] vis, int stamp) {
        for (int v : adj[u]) {
            if (vis[v] == stamp) {
                continue;
            }
            vis[v] = stamp;
            if (matchCol[v] == -1 || dfs(matchCol[v], adj, matchCol, vis, stamp)) {
                matchCol[v] = u;
                return true;
            }
        }
        return false;
    }
}
