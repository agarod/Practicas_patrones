

class Internet implements Observer {
       @Override
       public void update(float interest) {
              System.out.println("Internet: tasa de interesa actualizada, el nuevo valor es: : "+ interest);
       }
}
