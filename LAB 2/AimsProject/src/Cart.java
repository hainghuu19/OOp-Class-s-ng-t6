package AimsProject;
public class Cart {

    private int qtyOrdered;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public int getQtyOrdered() {
        return qtyOrdered;
    }
    public Cart(){
        this.qtyOrdered = 0;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < 20) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
            return;
        }
        System.out.println("The cart is almost full");
    }
    public float totalCost(){
        float total = 0 ;
        for(int i = 0 ; i < qtyOrdered ; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;

    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int RmovePos = -1;
        for(int i = 0 ; i < qtyOrdered ; i++) {
            if (disc.getTitle().equals(itemsOrdered[i].getTitle())){
                RmovePos = i;
                break;
            }
        }
        DigitalVideoDisc[] tmp = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        tmp = itemsOrdered;
        if(RmovePos == -1) return;
        int j = 0;
        for(int i = 0 ; i < qtyOrdered ; i++) {
            if (i != RmovePos) {
                itemsOrdered[j] = tmp[i];
                j++;
            }
        }
        qtyOrdered--;
        System.out.println("The disc has been removed");
    }
    
}
