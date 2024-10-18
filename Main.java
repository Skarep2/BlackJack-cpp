import java.util.Random;
import java.util.ArrayList;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                enum Suite {
                    HEARTS("Corazones", "♥");

                    final String suiteName;
                    final String suiteSymbol;

                    Suite(String suiteName, String suiteSymbol) {
                        this.suiteName = suiteName;
                        this.suiteSymbol = suiteSymbol;
                    }

                    String getSuiteName() {
                        return suiteName;
                    }

                    String getSuiteSymbol() {
                        return suiteSymbol;
                    }
                }

                enum Figure {
                    TWO("2", 2),
                    THREE("3", 3),
                    JACK("J", 10),
                    QUEEN("Q", 10),
                    KING("K", 10),
                    ACE("A", 11);

                    final String figureName;
                    final int figureValue;

                    Figure(String figureName, int figureValue) {
                        this.figureName = figureName;
                        this.figureValue = figureValue;
                    }

                    String getFigureName() {
                        return figureName;
                    }

                    int getFigureValue() {
                        return figureValue;
                    }
                }

                class Card {
                    final Suite suite;
                    final Figure figure;
                    boolean isTaken = false; 

                    Card(Suite suite, Figure figure) {
                        this.suite = suite;
                        this.figure = figure;
                    }

                    String getCardName() {
                        return figure.getFigureName() + suite.getSuiteSymbol();
                    }

                    int getCardValue() {
                        return figure.getFigureValue();
                    }
                }

                class Deck {
                    Card[] cards;

                    Deck() {
                        cards = new Card[52];
                        int index = 0;
                        for (Suite suite : Suite.values()) {
                            for (Figure figure : Figure.values()) {
                                cards[index] = new Card(suite, figure);
                                index++;
                            }
                        }
                    }

                    void shuffle() {
                        Random random = new Random();
                        for (int i = 0; i < cards.length; i++) {
                            int randomIndex = random.nextInt(cards.length);
                            Card temp = cards[i];
                            cards[i] = cards[randomIndex];
                            cards[randomIndex] = temp;
                        }
                    }
                }

                class Player {
                    String name;
                    ArrayList<Card> cards = new ArrayList<>();

                    Player(String name) {
                        this.name = name;
                    }
                }

                class Blackjack {
                    Deck deck;
                    Player player;
                    Player dealer;

                    Blackjack(String playerName) {
                        deck = new Deck();
                        player = new Player(playerName);
                        dealer = new Player("Dealer");
                    }
                }


        class BlackjackGame {
            int player = 0;
            int dealer = 0;
            String playerMessage = "Las cartas del jugador son: ";
            String dealerMessage = "Las cartas del dealer son: ";
            int[] cards = new int[52];

            // Función para crear el mazo
            void createDeck() {
                int cardValue = 2;
                int cardCount = 0;
                for (int figure = 1; figure <= 4; figure++) {
                    for (int card = 1; card <= 13; card++) {
                        switch (card) {
                            case 10:
                            case 11:
                            case 12:
                                cardValue = 10;
                                break;
                            case 13:
                                cardValue = 11;
                                break;
                            default:
                                break;
                        }
                        cards[cardCount] = cardValue;
                        cardCount++;
                        cardValue++;
                    }
                    cardValue = 2;
                }
            }

            
            int drawCard() {
                Random random = new Random();
                int card = random.nextInt(52); 
                return cards[card]; 
            }

            // Función para iniciar el juego y repartir las cartas
            void initGame() {
                // Repartir dos cartas al jugador
                player = drawCard() + drawCard();
                System.out.println(playerMessage + player);

                // Repartir dos cartas al dealer
                dealer = drawCard() + drawCard();
                System.out.println(dealerMessage + dealer);
            }

            // Función para validar el ganador
            void checkWinner() {
                if (player == 21) {
                    System.out.println("¡Ganaste con 21 puntos!");
                } else if (player > dealer && player <= 21) {
                    System.out.println("¡Ganaste!");
                } else if (player == dealer) {
                    System.out.println("¡Empate!");
                } else {
                    System.out.println("¡Perdiste!");
                }
            }

            public static void main(String[] args) {
                BlackjackGame game = new BlackjackGame();
                game.createDeck();
                game.initGame();
                game.checkWinner();
            }
        }

    }
        }

