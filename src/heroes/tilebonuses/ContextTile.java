package heroes.tilebonuses;

import heroes.Hero;
/*
    Se creeaza un context potrivit actiunii dictata de logica jocului.
    Contextul este manipulat in atribuirea bonusurilor corecte fiecarui erou.
 */
public class ContextTile {
    private TileBonusStrategy strategy;
    // Se alege contextul in concordanta cu tipul de teren
    public ContextTile(final char tile) {
        if (tile == 'V') {
            this.strategy = new VolcanicModifier();
        }
        if (tile == 'W') {
            this.strategy = new WoodsModifier();
        }
        if (tile == 'D') {
            this.strategy = new DesertModifier();
        }
        if (tile == 'L') {
            this.strategy = new LandModifier();
        }
    }
    // Se executa strategia contextului creat
    public final void executeStrategy(final Hero h) {
        strategy.setPlayersStrategy(h);
    }
}
