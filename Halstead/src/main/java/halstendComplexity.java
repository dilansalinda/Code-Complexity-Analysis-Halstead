import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class halstendComplexity {

    public static void main(String[] args) throws FileNotFoundException {
        String[] keywords = {"public", "System", "out","println", "void", "class", "string", "int", "static", "abstract",
                "assert", "boolean", "break", "Byte", "Case", "Catch", "Char", "Const", "Continue", "Default", "Do", "Double",
                "Else", "enum", "Extends", "Final", "Finally", "Float", "For", "goto", "If", "implements", "import", "Instance of",
                "interface", "long", "native", "new", "package", "private", "protected", "return", "short", "strictfp", "super",
                "switch", "synchronized", "this", "throw", "throws", "transient", "try", "volatile", "while"};
        ArrayList<String> operators = new ArrayList<String>();
        ArrayList<String> operands = new ArrayList<String>();
        ArrayList<String> variables = new ArrayList<String>();
        int operatorCount = 0, operandCount = 0;

//        try {
//            reader = new BufferedReader(new FileReader(new File("F:\\Halstead Complexity\\Java-Code-Complexity-Analysis---Halstead-Complexity\\Halstead\\src\\test\\java\\car.java")));
//
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                line = line.trim();
//                for (String keyword : keywords) {
//                    if (line.startsWith(keyword)) {
//                        //line = line.substring(0 + keyword.length());
//                        operators.add(keyword);
//                        operatorCount++;
//                    }
//                }
////                for (String datatype : datatypes) {
////                    if (line.startsWith(datatype)) {
////                        operators.add(datatype);
////                        operatorCount++;
////                        int index = line.indexOf(datatype);
////                        line = line.substring(index + datatype.length(), line.length() - 1);  // -1 to ignore the semicolon
////                        String[] vars = line.split(",");
////                        for (String v : vars) {
////                            v = v.trim();
////                            variables.add(v);
////                        }
////                    }
////                }
//            }
//            System.out.println(operators);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//*************************************
//        try {
//            File file = new File("F:\\\\Halstead Complexity\\\\Java-Code-Complexity-Analysis---Halstead-Complexity\\\\Halstead\\\\src\\\\test\\\\java\\\\SwapNumbers.java");
//            Scanner input = new Scanner(file);
//
//            int count = 0;
//            boolean multiLineComment = false;
//            while (input.hasNext()) {
//
//                    String word = input.next()
//                            .replaceAll("\\[", "")
//                            .replaceAll("\\]", "")
//                            .replaceAll("\\{", "")
//                            .replaceAll("\\}", "")
//                            .replaceAll("\\.", "");
//
//                    for (String dd : word.split("\\(")) {
//                        for (String keyword : keywords) {
//                            if (dd.equalsIgnoreCase(keyword)) {
//                                operators.add(dd);
//                                operatorCount++;
//                            }
//
//                        }
//                    }
//                    count = count + 1;
//                }
//
//            System.out.println(operators);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        String fileName = "F:\\Halstead Complexity\\Java-Code-Complexity-Analysis---Halstead-Complexity\\Halstead\\src\\test\\java\\SwapNumbers.java";
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            list = stream
                    .filter(line -> !line.contains("//"))
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.replaceAll("\\}",""))
                    .map(line -> line.replaceAll("\\{",""))
                    .map(line -> line.replaceAll("\\(",""))
                    .map(line -> line.replaceAll("\\)",""))
                    .map(line -> line.replaceAll("\\[",""))
                    .map(line -> line.replaceAll("\\]",""))
                    .map(line -> line.replaceAll("\\.",""))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        //list.forEach(System.out::print);
        for (String keyword : list) {
            operators.add(keyword);
            operatorCount++;
        }
        System.out.println(list);

    }

}
