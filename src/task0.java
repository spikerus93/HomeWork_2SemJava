public class task0 {
    public static void main(String[] args){
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        } else {
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}
    class Answer{
        public static StringBuilder answer(String QUERY, String PARAMS){
            StringBuilder result = new StringBuilder(QUERY);
            String task = PARAMS;
            String[] parts = task.split(",");

            for (int i = 0; i < parts.length; i++) {
                if (parts[i].contains("null")) parts[i] = "0:0";
                parts[i] = parts[i].replace("\"","");
                parts[i] = parts[i].replace("{","");
                parts[i] = parts[i].replace("}","");
                parts[i] = parts[i].replace(" ","");

            }

            String array[][] = new String[parts.length][2];

            for (int j = 0; j < array.length; j++) {
                int flag = 0;
                String[] temp = parts[j].split(":");
                for (int k = 0; k < 2; k++) {
                    array[j][k] = temp[k];
                    if (!array[j][k].equals("0")){
                        if (k == 0)  result.append(array[j][k] + "='");
                        else result.append(array[j][k]);

                    }
                    else flag = 1;

                }
                if (j < array.length - 1) result.append("' and ");
                if (flag == 1) result.setLength(result.length()-5);


            }
            return result;

        }
    }

//    Дополнительное решение задачи
//    class Answer {
//    public static StringBuilder answer(String QUERY, String PARAMS){
//        String paramsNew = PARAMS.replace('{',' ').replace('}', ' ');
//        String[] params = paramsNew.split(",");
//        StringBuilder stringBuilder = new StringBuilder(QUERY);
//
//        for (int i = 0; i < params.length; i++){
//            String[] elements = params[i].replace('"', ' ').split(":");
//            if(!"null".equals(elements[1].trim())){
//              stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
//                if (i < params.length - 2) stringBuilder.append(" and ");
//            }
//        }
//        return stringBuilder;
//    }
//}
//
//
//public class Printer{
//    public static void main(String[] args) {
//      String QUERY = "";
//      String PARAMS = "";
//
//      if (args.length == 0) {
//        QUERY = "select * from students where ";
//        PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
//      }
//      else{
//        QUERY = args[0];
//        PARAMS = args[1];
//      }
//
//      Answer ans = new Answer();
//      System.out.println(ans.answer(QUERY, PARAMS));
//    }
//}