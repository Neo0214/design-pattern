package org.group11.Patterns.Builder;

public class Coffee {
        private int espressoNum;
        private int milkNum;
        private int milkForthNum;
        private int cocoaNum;
        private int price;

        private Coffee(Builder builder) {
            this.espressoNum = builder.espressoNum;
            this.milkNum = builder.milkNum;
            this.milkForthNum = builder.milkForthNum;
            this.cocoaNum = builder.cocoaNum;
            this.price = builder.price;
        }

        //开放全部get与set方法
    public int getEspresso() {
        return espressoNum;
    }
    public void setEspresso(int espressoNum) {
        this.espressoNum = espressoNum;
    }
    public int getMilk() {
        return milkNum;
    }
    public void setMilk(int milkNum) {
        this.milkNum = milkNum;
    }
    public int getMilkForth() {
        return milkForthNum;
    }
    public void setMilkForth(int milkForthNum) {
        this.milkForthNum = milkForthNum;
    }
    public int getCocoa() {
        return cocoaNum;
    }
    public void setCocoa(int cocoaNum) {
        this.cocoaNum = cocoaNum;
    }

    public int getPrice() {
            return price;
    }
    public static class CoffeeMemento {
        private final int espresso;
        private final int milk;
        private final int milkForth;
        private final int cocoa;

        private CoffeeMemento(int espresso, int milk, int milkForth, int cocoa) {
            this.espresso = espresso;
            this.milk = milk;
            this.milkForth = milkForth;
            this.cocoa = cocoa;
        }

        public int getEspresso() {
            return espresso;
        }

        public int getMilk() {
            return milk;
        }

        public int getMilkForth() {
            return milkForth;
        }

        public int getCocoa() {
            return cocoa;
        }
    }

    public CoffeeMemento createMemento() {
        return new CoffeeMemento(espressoNum, milkNum, milkForthNum, cocoaNum);
    }

    public void restoreFromMemento(CoffeeMemento memento) {
        this.espressoNum = memento.getEspresso();
        this.milkNum = memento.getMilk();
        this.milkForthNum = memento.getMilkForth();
        this.cocoaNum = memento.getCocoa();
        this.price =  calculatePrice();
    }

    int calculatePrice() {
        return espressoNum * 2 + milkNum * 1 + milkForthNum * 1 + cocoaNum * 2;
    }

    public static class Builder {
            private int espressoNum;
            private int milkNum;
            private int milkForthNum;
            private int cocoaNum;
            private int price;

            public Builder espresso(int num) {
                this.espressoNum = num;
                return this;
            }

            public Builder milk(int num) {
                this.milkNum = num;
                return this;
            }

            public Builder milkForth(int num) {
                this.milkForthNum = num;
                return this;
            }

            public Builder cocoa(int num) {
                this.cocoaNum = num;
                return this;
            }

            public Builder Price() {
                price= espressoNum * 2 + milkNum * 1 + milkForthNum * 1 + cocoaNum * 2;
                return this;
            }

            public Coffee build() {
                return new Coffee(this);
            }

            public int getPrice() {
                return price;
            }
        }
}
