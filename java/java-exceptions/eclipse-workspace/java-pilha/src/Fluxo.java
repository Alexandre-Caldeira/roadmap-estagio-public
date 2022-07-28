public class Fluxo {

    public static void main(String[] args) {
        System.out.println("Ini do main");
        metodo1();
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        try{
        metodo2();
      } catch(NullPointerException | ArithmeticException | MinhaExcecao  e) {
    	String msg = e.getMessage(); // ArithmeticException
    	System.out.println("Excecao "+msg); 
    	e.printStackTrace();
      }
//        } catch(NullPointerException e) {
//        	String msg = e.getMessage(); // ArithmeticException
//        	System.out.println("Excecao "+msg); 
//        	e.printStackTrace();
//        }
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
        
        throw new MinhaExcecao("Algo deu muito errado");
        
//        throw new ArithmeticException("Deu erro");
        
//        for(int i = 1; i <= 5; i++) {
//            System.out.println(i);
////            throw new ArithmeticException();
//           	int a = i/0;
//            Conta c = null;
//            c.deposita();
//        }
        
//        System.out.println("Fim do metodo2");
    }
}