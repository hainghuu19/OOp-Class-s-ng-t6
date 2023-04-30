package AimsProject;
public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public DigitalVideoDisc(){}
    public DigitalVideoDisc(String title){
        super();
        setTitle(title);
    }
    public DigitalVideoDisc(String category , String title , float cost ){
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }
    public DigitalVideoDisc(String director, String category , String title , float cost ){
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        setDirector(director);
    }
    public DigitalVideoDisc(String title , String category , String director , int length , float cost) {
        setTitle(title);
        setCategory(category);
        setCost(cost);
        setDirector(director);
        setLength(length);
    }
}
