
class Newspaper implements Observer {
       @Override
       public void update(float interest) {
              System.out.println("Periodico: tasa de interesa actualizada, el nuevo valor es: "+ interest);
       }
}
