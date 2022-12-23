package Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Phone {
    private long id;
    private String model;
    private int memory;
    private LocalDate yearOfIssue;
    private BigDecimal price;

    public Phone(long id, String model, int memory, LocalDate yearOfIssue, BigDecimal price) {
        this.id = id;
        try {
            if(model.equals(null)){
                throw new RuntimeException();
            }else
            this.model = model;
        }catch (RuntimeException e){
            System.out.println("Model can't be null");
        }
try {
    if(memory<0){
        throw new RuntimeException();
    }else
        this.memory = memory;
} catch (RuntimeException e){
    System.out.println("Memory can't be negative");
}
 try {
     if(yearOfIssue.isAfter(LocalDate.now())){
         throw new RuntimeException();
     }else {
         this.yearOfIssue = yearOfIssue;
     }
 }catch (RuntimeException e){
     System.out.println("Year of issue can't be future");
 }

 try {
     if(price.intValue()<0){
         throw new RuntimeException();
     }else {
         this.price = price;
     }
 }catch (RuntimeException e){
     System.out.println("Price can't be negative");
 }


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public LocalDate getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(LocalDate yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", memory=" + memory +
                ", yearOfIssue=" + yearOfIssue +
                ", price=" + price +
                '}';
    }
}
