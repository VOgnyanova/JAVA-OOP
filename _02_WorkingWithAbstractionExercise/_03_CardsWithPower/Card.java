package _03_CardsWithPower;


public class Card {
    private CardSuits cardSuits;
    private CardRanks cardRanks;
    private int power;

    public Card(CardSuits cardSuits, CardRanks cardRanks) {
        this.cardSuits = cardSuits;
        this.cardRanks = cardRanks;
    }

    public CardSuits getCardSuits() {
        return cardSuits;
    }

    public void setCardSuits(CardSuits cardSuits) {
        this.cardSuits = cardSuits;
    }

    public CardRanks getCardRanks() {
        return cardRanks;
    }

    public void setCardRanks(CardRanks cardRanks) {
        this.cardRanks = cardRanks;
    }

    public int getPower() {
        return this.cardRanks.getPower() + this.cardSuits.getPower() ;
    }

    public void setPower(int power) {
        this.power = power;
    }

}
