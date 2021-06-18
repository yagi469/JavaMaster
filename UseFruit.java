abstract class Fruit {
    abstract String whatColor();
}
class Apple extends Fruit {
    String whatColor() {
        return "りんごの色は赤";
    }
}
class Orange extends Fruit {
    String whatColor() {
        return "みかんの色はオレンジ";
    }
}
class Melon extends Fruit {
    String whatColor() {
        return "メロンの色は緑";
    }
}
class UseFruit {
    public class void main(String[] args) {
        Fruit[] fruits = { new Apple(), new Melon(), new Orange() };
        
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i].whatColor());
        }
    }
}

// 中小クラスは、フィールドやコンストラクタまたは完成されたメソッドを持っていてもかまわない。
abstract class Fruit {
    private double weight;
    
    public double getWeight() {
        return weight;
    }
    
    Fruit(double weight) {
        this.weight = weight;
    }
    
    abstract String whatColor();
}
