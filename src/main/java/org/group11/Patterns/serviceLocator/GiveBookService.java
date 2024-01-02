package org.group11.Patterns.serviceLocator;


import org.group11.Patterns.Mediator.DonationMediator;
import org.group11.Patterns.abstractFactory.AbstractFactory;
import org.group11.Patterns.abstractFactory.ConcreteFactory;

public class GiveBookService implements Service{
    @Override
    public String getName() {
        return "GiveBookService";
    }
    @Override
    public void execute(String... args) {
        ConcreteFactory factory = new ConcreteFactory();
        DonationMediator donationMediator = new DonationMediator(factory);
        donationMediator.handlePreDonation(Integer.parseInt(args[0]));
    }
}
