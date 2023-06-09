package H588DesignIn_MemoryFileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Time: O(N)
 * Space: O(N)
 */
public class FileSystem {
    private Node root;

    public FileSystem() {
        root = new Node("/");
    }

    public List<String> ls(String path) {
        List<String> output = new ArrayList<>();
        String[] tokens = path.split("/");
        if (path.length() == 1) {
            // root
            for (Node d : root.dirs) {
                output.add(d.dirName);
            }
            for (String[] f : root.files) {
                output.add(f[0]);
            }
        } else {
            // recursively find the path we want
            Node node = find(tokens, false);
            if (node != null) {
                for (Node d : node.dirs) {
                    output.add(d.dirName);
                }
                for (String[] f : node.files) {
                    output.add(f[0]);
                }
            } else {
                node = find(tokens, true);
                if (node != null) {
                    output.add(tokens[tokens.length - 1]);
                }
            }
        }
        Collections.sort(output);
        return output;
    }
    // find the path folder
    private Node find(String[] tokens, boolean isFile) {
        Node node = root;
        for (int i = 1; i < tokens.length - 1; i++) {
            boolean flag = true;
            for (Node d : node.dirs) {
                if (d.dirName.equals(tokens[i])) {
                    node = d;
                    flag = false;
                    break;
                }
            }
            if (flag) {return null;}
        }
        if (!isFile) {
            for (Node d : node.dirs) {
                if (d.dirName.equals(tokens[tokens.length - 1])) {
                    return d;
                }
            }
            return null;
        }
        return node;
    }

    public void mkdir(String path) {
        String[] tokens = path.split("/");
        Node node = root;
        for (int i = 1; i < tokens.length; i++) {
            boolean flag = false;
            for (Node d : node.dirs) {
                if (d.dirName.equals(tokens[i])) {
                    node = d;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            Node sub = new Node(tokens[i]);
            node.dirs.add(sub);
            node = sub;
        }
    }

    public void addContentToFile(String filePath, String content) {
        mkdir(filePath.substring(0, filePath.lastIndexOf("/") + 1));
        String[] tokens = filePath.split("/");
        Node node = find(tokens, true);
        for (String[] f : node.files) {
            if (f[0].equals(tokens[tokens.length - 1])) {
                f[1] += content;
                return;
            }
        }
        node.files.add(new String[] {tokens[tokens.length - 1], content});

    }

    public String readContentFromFile(String filePath) {
        String[] tokens = filePath.split("/");
        Node node = find(tokens, true);
        if (node != null) {
            for (String[] f : node.files) {
                if (f[0].equals(tokens[tokens.length - 1])) {
                    return f[1];
                }
            }
        }
        return "";
    }
}

class Node {
    String dirName;
    List<Node> dirs;
    List<String[]> files;

    public Node(String dirName) {
        this.dirName = dirName;
        dirs = new ArrayList<>();
        files = new ArrayList<>();
    }
}


/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
