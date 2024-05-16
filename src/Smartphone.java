public class Smartphone {
    private String brand = "undefined";
    private String model = "undefined";
    private int storageCapacity = 64;
    private double price = 100;

    public Smartphone(){};

    public Smartphone(String brand, String model, int storageCapacity, double price) {
        setBrand(brand);
        setModel(model);
        setStorageCapacity(storageCapacity);
        setPrice(price);
    }

    public Smartphone(Smartphone other) {
        this(other.brand, other.model, other.storageCapacity, other.price);
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStorageCapacity(int storageCapacity) {
        if (storageCapacity > 0)
            this.storageCapacity = storageCapacity;
    }

    public void setPrice(double price) {
        if(price > 0.0)
            this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String s="";
        s+=String.format("Brand: %s, Model: %s, Storage Capacity: %d, Price: %.2f \n", this.brand, this.model, this.storageCapacity, this.price);
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        boolean verifica=false;
        if(this == obj)
            verifica=true;
        else{
            if(obj instanceof Smartphone){
                Smartphone s = (Smartphone)obj;
                if(this.brand.equalsIgnoreCase(s.brand)){
                    if(this.model.equalsIgnoreCase(s.model)){
                        if(this.price == s.price){
                            if(this.storageCapacity == s.storageCapacity)
                                verifica=true;
                        }
                    }
                }
            }
        }

        return verifica;
    }
    
}
