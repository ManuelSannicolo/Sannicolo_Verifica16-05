public class App {
    public static void main(String[] args) throws Exception {
        
MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
Smartphone smartphone1 = new Smartphone("Apple", "iPhone 12", 128, 999.99);
Smartphone smartphone2 = new Smartphone("Samsung", "Galaxy S21", 256, 899.99);
Smartphone smartphone3 = new Smartphone("OnePlus", "9 Pro", 256, 1069.99);
magazzinoSmartphone.addSmartphone(smartphone1);
magazzinoSmartphone.addSmartphone(smartphone2);
magazzinoSmartphone.addSmartphone(smartphone3);

// Generate test cases for toString method in MagazzinoSmartphone
// MagazzinoSmartphone: 
// Brand: Apple, Model: iPhone 12, Storage Capacity: 128GB, Price: 999.99
// Brand: Samsung, Model: Galaxy S21, Storage Capacity: 256GB, Price: 899.99
// Brand: OnePlus, Model: 9 Pro, Storage Capacity: 256GB, Price: 1069.99
System.out.println(magazzinoSmartphone); 


magazzinoSmartphone.removeSmartphone(smartphone2);
System.out.println("magazzinoSmartphone senza Samsung Galaxy S21");
System.out.println(magazzinoSmartphone);
System.out.println("magazzinoSmartphone.getSmartphoneByBrand(\"Apple\")");
System.out.println(magazzinoSmartphone.getSmartphoneByBrand("Apple"));
System.out.println(magazzinoSmartphone.getSmartphonesByStorageCapacity(256));
System.out.println(magazzinoSmartphone.getSmartphonesByPriceRange(900, 1100));


// Generate test cases for equals method
System.out.println("smartphone1.equals(smartphone2)");
System.out.println(smartphone1.equals(smartphone2)); // false
System.out.println("smartphone2.equals(smartphone3)");
System.out.println(smartphone2.equals(smartphone3)); // false
System.out.println("smartphone1.equals(smartphone1)");
System.out.println(smartphone1.equals(smartphone1)); // true

// Generate test cases for toString method
System.out.println("smartphone1.toString()"); 
System.out.println(smartphone1); // Brand: Apple, Model: iPhone 12, Storage Capacity: 128GB, Price: €999.99

// Generate test cases for costruttore di copia
MagazzinoSmartphone magazzinoSmartphone2 = new MagazzinoSmartphone(magazzinoSmartphone);

// Generate test cases for equals method in MagazzinoSmartphone
System.out.println(magazzinoSmartphone.equals(magazzinoSmartphone2)); // true





// magazzinoSmartphone2.removeSmartphone(smartphone3);
// System.out.println(magazzinoSmartphone.equals(magazzinoSmartphone2));

// magazzinoSmartphone2.addSmartphone(smartphone3);
// magazzinoSmartphone2.addSmartphone(smartphone3);
// magazzinoSmartphone2.addSmartphone(smartphone3);
// magazzinoSmartphone2.addSmartphone(smartphone3);
// System.out.println(magazzinoSmartphone2);
// magazzinoSmartphone2.removeSmartphone(smartphone3);
// System.out.println(magazzinoSmartphone2);

// System.out.println(magazzinoSmartphone.getSmartphoneByBrand("OnEpLus"));


    }
}
