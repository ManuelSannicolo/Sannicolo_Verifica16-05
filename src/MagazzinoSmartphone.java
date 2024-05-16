public class MagazzinoSmartphone {
    private Smartphone[] smartphones;
    private int count;

    public MagazzinoSmartphone() {
        this(10); // Assuming initial capacity of 10
        count = 0;
    }

    public MagazzinoSmartphone(int max){
        if(max > 0)
            smartphones = new Smartphone[max];
        count = 0;
    }

    public MagazzinoSmartphone(MagazzinoSmartphone other) {
        smartphones = new Smartphone[other.smartphones.length];
        for (int i = 0; i < other.count; i++) {
                addSmartphone(other.smartphones[i]);
        }
    }


    //metodo di supporto
    public int cercaSmartphone(Smartphone smartphone){
        int i=0;
        int result=-1;
        boolean trovato=false;
        while(!trovato && i < count){
            if(this.smartphones[i].equals(smartphone)){
                result=i;
                trovato=true;
            }
            i++;
                
        }
        return result;
    }


    public void addSmartphone(Smartphone smartphone) {
        // ho fatto in modo che sia possibile inserire più smartphone uguali; per non renderlo possibile:
        //int presente = cercaSmartphone(smartphone);
        if(smartphone != null && count < smartphones.length) //inserire questa anche condizione  "&& presente==-1"
            this.smartphones[count++]= new Smartphone(smartphone);
        
        
    }

    public void removeSmartphone(Smartphone smartphone) {
        int pos=cercaSmartphone(smartphone);
        //ho fatto in modo che se ci fosserro più smartphone uguali, li elimina tutti;
        //per fare in modo che elimini solo il primo, sostituire il while con un if ed eliminare l'operazione sotto
        while(pos!=-1){ 
            this.smartphones[pos]=null;
            for (int i = pos; i < count-1; i++) {
                this.smartphones[i]=this.smartphones[i+1];
            }
            this.smartphones[--count]=null;
            pos=cercaSmartphone(smartphone); //eliminare in caso questa riga
        }

    }


    //non toccare, completo
    public Smartphone[] getSmartphonesArray() {
        Smartphone[] smartphoneArray = new Smartphone[count];
        System.arraycopy(smartphones, 0, smartphoneArray, 0, count);
        return smartphoneArray;
    }


    public Smartphone getSmartphoneByBrand(String brand) {
        Smartphone smartphone = null;
        int i=0;
        boolean trovato=false;
        while (!trovato && i < count){
            String brandCorrente = this.smartphones[i].getBrand();
            if(brandCorrente.equalsIgnoreCase(brand)){ 
                smartphone=new Smartphone(this.smartphones[i]);
                trovato=true;
            }
            i++;
        }


        return smartphone;
    }

    public MagazzinoSmartphone getSmartphonesByStorageCapacity(int storageCapacity) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone(this.smartphones.length);
        if(storageCapacity > 0){
            for (int i = 0; i < count; i++) {
                if(this.smartphones[i].getStorageCapacity()==storageCapacity) //volendo si può pure fare > o < 
                    magazzinoSmartphone.addSmartphone(this.smartphones[i]);
            }
        }

        return magazzinoSmartphone;
    }


    public MagazzinoSmartphone getSmartphonesByPriceRange(double minPrice, double maxPrice) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone(this.smartphones.length);
        if(minPrice>0 && maxPrice>0 && minPrice<=maxPrice){
            for (int i = 0; i < count; i++) {
                double currentPrice = this.smartphones[i].getPrice();
                if(currentPrice>=minPrice && currentPrice<=maxPrice)
                    magazzinoSmartphone.addSmartphone(this.smartphones[i]);
            }
        }

        return magazzinoSmartphone;
    }

    @Override
    public String toString() {
        String result = "\nMagazzinoSmartphone:\n";
        for (int i = 0; i < count; i++) {
            result+=this.smartphones[i];
        }
        return result;
    }


    public int getCount() {
        return count;
    }


    public boolean equals(Object obj) {
       boolean verifica = false;
       if(this == obj)
        verifica = true;
       else{
        if( obj instanceof MagazzinoSmartphone){
            MagazzinoSmartphone m = (MagazzinoSmartphone)obj;
            if(m.count == this.count){
                int i=0;
                boolean diversi=false;
                MagazzinoSmartphone copia = new MagazzinoSmartphone(m);
                while(!diversi && i < count){
                    if(copia.cercaSmartphone(this.smartphones[i]) == -1) //il mio equals si basa sulla presenza degli smartphone nel emagazzino, indipendentemente dalla posizione
                        diversi=true;
                    else
                        copia.removeSmartphone(this.smartphones[i]);
                        //ho creato una copia del'oggetto dato come parametro in modo tale da poter rimuovere gli elementi che sono presenti in comune; in questo modo se ho più telefono uguali
                        //di diverso tipo, controllo che i due magazzini contenghino lo stesso numero di smartphone uguali. Se non volessi fare questo basterebbe rimuovere la creazione della copia
                        //e togliere l'else dell'if sopprastante. Ho pensato che questo potesse essere il miglior metodo di verifica dell'uguaglianza   
                    i++;
                }
                if(!diversi)
                    verifica=true;
            }
        }
       }

        return verifica;
    }

}