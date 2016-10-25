package potter;

public class Discount {

    public double price(int[] books) {
        int[] amountOfBooks = { 0, 0, 0, 0, 0 };

        for (int book : books) {
            amountOfBooks[book]++;
        }
        int booksLeft = books.length;

        double price = calculateDiscount(amountOfBooks, booksLeft);

        return price;
    }

    public double calculateDiscount(int[] amountOfBooks, int booksLeft) {
        double discount;
        double price = 0;
        int differentBooks = 0;

        while (booksLeft > 0) {
            for (int i = 0; i < amountOfBooks.length; i++) {
                if (amountOfBooks[i] > 0) {
                    differentBooks++;
                    amountOfBooks[i]--;
                    booksLeft--;
                }
            }

            discount = getDiscount(differentBooks);

            price += differentBooks * 8 * discount;
            differentBooks = 0;
        }
        return price;
    }

    public double getDiscount(int differentBooks) {
        double discount;
        switch (differentBooks) {
            case 2:
                discount = 0.95;
                break;
            case 3:
                discount = 0.9;
                break;
            case 4:
                discount = 0.8;
                break;
            case 5:
                discount = 0.75;
                break;
            case 1:
            default:
                discount = 1;

        }
        return discount;
    }

}
