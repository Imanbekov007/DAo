import Model.Phone;
import Service.Impl.PhoneImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Phone> phoneList=new LinkedHashSet<>(Arrays.asList(
        new Phone(12,"Iphone",64, LocalDate.ofYearDay(2000,5),new BigDecimal(4500)),
        new Phone(13,"Redmi",128, LocalDate.ofYearDay(2010,5),new BigDecimal(42300)),
        new Phone(14,"Samsung",64, LocalDate.ofYearDay(2020,5),new BigDecimal(4500)),
        new Phone(15,"Nokia",4, LocalDate.ofYearDay(2015,5),new BigDecimal(4430)),
        new Phone(16,"Iphone",32, LocalDate.ofYearDay(2011,5),new BigDecimal(49000))
));
        Phone phone=new Phone(1L,"Huawei",2,LocalDate.ofYearDay(1999,5),new BigDecimal(2000));
        PhoneImpl phoneimpl=new PhoneImpl();
        System.out.println(phoneimpl.addPhones(phoneList));
        System.out.println(phoneimpl.removePhoneById(13L));
        System.out.println(phoneimpl.getAllPhones());
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~```");
        System.out.println(phoneimpl.filterPhonesByPrice(4490,42300));
    }
}