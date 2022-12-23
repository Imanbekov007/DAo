package Service.Impl;

import DAO.Database;
import Model.Phone;
import Service.PhoneService;

import java.util.*;


public class PhoneImpl extends Database implements PhoneService  {




    @Override
    public String addPhones(Set<Phone> phones) {
        phonesdata.addAll(phones);
        return "Successfully added";
    }

    @Override
    public Queue<Phone> getPhonesByModel(String model) {
        Queue<Phone>getphbymodel=new LinkedList<>();
        for (Phone a:phonesdata) {
            if(a.getModel().contains(model)){
                getphbymodel.add(a);
            }

        }
        return getphbymodel;
    }

    @Override
    public String updatePhone(Long phoneId, Phone newPhone) {
//        List<Phone> phoneList = phonesdata.stream().filter(x -> x.getId() == phoneId).toList();

        Phone currentPhone = null;
        for (Phone phonesdatum : phonesdata) {
            if (phoneId == phonesdatum.getId()) currentPhone = phonesdatum;

        }

        currentPhone.setId(newPhone.getId());

        
        return "Succesfully changed";
    }

    @Override
    public String removePhoneById(Long phoneId) {
        phonesdata.removeIf(x->x.getId()==phoneId);
        return "Succesfully deleted by id";
    }

    @Override
    public Deque<Phone> getAllPhones() {
        Deque<Phone>gelall=new LinkedList<>(phonesdata);
        return gelall;
    }

    @Override
    public List<Phone> sortPhonesByYearOfIssue() {
        List<Phone> phoneListyear = phonesdata.stream().sorted(Comparator.comparing(Phone::getYearOfIssue)).toList();
        List<Phone> phoneListyear2 = phonesdata.stream().sorted(Comparator.comparing(Phone::getYearOfIssue).reversed()).toList();
        Scanner scanner=new Scanner(System.in);
        if(scanner.nextInt()==1){
            return phoneListyear;
        }else {
            return phoneListyear2;
        }

    }

    @Override
    public List<Phone> filterPhonesByPrice(int fromThisPrice, int upToThisPrice) {
        List<Phone> phoneListprice = phonesdata.stream().filter(x -> x.getPrice().intValue() > fromThisPrice && x.getPrice().intValue() < upToThisPrice).toList();
        return phoneListprice;
    }

    @Override
    public List<Phone> findPhonesWithLargeMemoryAndSmallMemory() {
        List<Phone> phoneListmax = phonesdata.stream().max(Comparator.comparing(Phone::getMemory)).stream().toList();
        List<Phone> phoneListmin = phonesdata.stream().min(Comparator.comparing(Phone::getMemory)).stream().toList();
        Scanner scanner=new Scanner(System.in);
        if(scanner.nextInt()==1){
            return phoneListmax;
        }else {
            return phoneListmin;
        }


    }

    @Override
    public String deleteAllPhones() {
        phonesdata.clear();
        return "Successfully deleted";
    }
}
