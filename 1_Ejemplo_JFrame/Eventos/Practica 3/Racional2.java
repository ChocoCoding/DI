public class Racional2 {
   //Atributos
   private int numerador;
   private int denominador;
   
   //Constructores
   public Racional2() {
      numerador   = 1;
      denominador = 1;
   }
   
   public Racional2(int num, int den) {
      numerador = num;
      if (den == 0) {
         denominador = 1;         //no se permite asignar un denominador 0
      }
      else {
         denominador = den;
      }
   }
   
   //Resto de m�todos
   public void asignarDatos(int num, int den) {
      numerador = num;
      if (den != 0) {            //si se intenta asignar un denominador 0, se ignora
         denominador = den;
      }
   }
   
   public int devolverNumerador(){
      return numerador;
     
   }
   
   public int devolverDenominador() {
      return denominador;
   }
  
   public void sumar(Racional2 n1, Racional2 n2) {
     
      this.numerador = (n1.numerador * n2.denominador) + (n1.denominador * n2.numerador);
      this.denominador = n1.denominador * n2.denominador;
     
   }
   
   public void restar(Racional2 n1, Racional2 n2) {
       
      this.numerador = (n1.numerador * n2.denominador) - (n1.denominador * n2.numerador);
      this.denominador = n1.denominador * n2.denominador;
   }
   
   public void multiplicar(Racional2 n1, Racional2 n2) {
     
      this.numerador = n1.numerador * n2.numerador;
      this.denominador = n1.denominador * n2.denominador;
    }
   
   public void dividir(Racional2 n1, Racional2 n2) {
     
      this.numerador = n1.numerador * n2.denominador;
      this.denominador = n1.denominador * n2.numerador;
     
   }
}