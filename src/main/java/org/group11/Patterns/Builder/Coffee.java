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

    public int getPrice() {
            return price;
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
