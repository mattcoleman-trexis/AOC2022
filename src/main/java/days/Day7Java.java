package days;

import util.InputReader;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Day7Java {
    static final String FILE = "directory.txt";
    //static final String FILE = "dir-test.txt";

    static Directory root = new Directory("/", null);
    static Directory cd = root;
    static int index = 1;
    public static void main(String[] args) throws Exception {
        List<String> lines = InputReader.INSTANCE.getInputAsList(7);

        while(index < lines.size()) {
            String cli = lines.get(index).substring(2);
            if ("ls".equals(cli)) {
                processLs(lines);
            } else {
                processCd(lines);
            }
        }

        int sizeUnder100K =
                getStreamOfDirs(root)
                        .mapToInt(Node::getTotalSize)
                        .filter(size -> size <= 100000)
                        .sum();

        System.out.println("total under 100K = " + sizeUnder100K);

        int needToClear = 30000000 - (70000000 - root.getTotalSize());

        int sizeOfSmallestSufficient =
                getStreamOfDirs(root)
                        .mapToInt(Node::getTotalSize)
                        .filter(size -> size >= needToClear)
                        .sorted()
                        .findFirst()
                        .orElseThrow();

        System.out.println(sizeOfSmallestSufficient);
    }

    private static Stream<Directory> getStreamOfDirs(Directory parent) {
        return
                Stream.concat(Stream.of(parent),
                        parent.getChildren().stream()
                                .filter(node -> !node.isFile)
                                .map(Directory.class::cast)
                                .flatMap(dir -> getStreamOfDirs(dir))
                )
                ;
    }


    private static void processCd(List<String> lines) {
        String dirname = lines.get(index++).substring(5);
        if ("..".equals(dirname)) {
            cd = cd.parent;
        } else {
            cd = cd.getChildren().stream()
                    .filter(node -> node.name.equals(dirname))
                    .findFirst()
                    .map(Directory.class::cast)
                    .orElseThrow();
        }
    }

    private static void processLs(List<String> lines) {
        while(++index < lines.size() && !lines.get(index).startsWith("$")) {
            String line = lines.get(index);
            if (line.startsWith("dir")) {
                String name = line.substring(4);
                cd.addChild(new Directory(name, cd));
            } else {
                String parts[] = line.split(" ");
                int size = Integer.parseInt(parts[0]);
                cd.addChild(new File(parts[1], size, cd));
            }
        }
    }
}

abstract class Node {
    public final boolean isFile;
    public final String name;
    public final Directory parent;
    public final int size;

    protected Node(String name, Directory parent, int size, boolean isFile) {
        this.isFile = isFile;
        this.name = name;
        this.parent = parent;
        this.size = size;
    }

    public List<Node> getChildren() {
        return List.of();
    }

    public void addChild(Node n) {
        throw new UnsupportedOperationException();
    }

    public int getTotalSize() {
        return size;
    }
}

class File extends Node {
    public File(String name, int size, Directory dir) {
        super(name, dir, size, true);
    }

}

class Directory extends Node {
    private final List<Node> children = new ArrayList<>();
    private final List<Node> pubChildren = Collections.unmodifiableList(children);

    public Directory(String name, Directory parent) {
        super(name, parent, 0, false);
    }

    public List<Node> getChildren() {
        return pubChildren;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public int getTotalSize() {
        return
                getChildren().stream()
                        .mapToInt(Node::getTotalSize)
                        .sum();
    }
}
