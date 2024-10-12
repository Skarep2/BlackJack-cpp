#include <iostream>
#include <random>
#include <string>
using namespace std;

int player = 0;
int dealer = 0;
string playerMessage = "Las cartas del jugador son: ";
string dealerMessage = "Las cartas del dealer son: ";
int cards[52];

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
                    cardValue = 11; // As vale 11 puntos
                    break;
                default:
                    break;
            }
            cards[cardCount] = cardValue;
            cardCount++;
            cardValue++;
        }
        cardValue = 2; // Reiniciar valor para la siguiente figura
    }
}

// Función para repartir una carta aleatoria
int drawCard() {
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<int> dist(1, 52);
    int card = dist(gen);
    return cards[card - 1];
}

// Función para iniciar el juego y repartir las cartas
void initGame() {
    // Repartir dos cartas al jugador
    player = drawCard() + drawCard();
    std::cout << playerMessage << player << std::endl;

    // Repartir dos cartas al dealer
    dealer = drawCard() + drawCard();
    std::cout << dealerMessage << dealer << std::endl;
}

// Función para validar el ganador
void checkWinner() {
    if (player == 21) {
        std::cout << "Ganaste con 21 puntos!" << std::endl;
    } else if (player > dealer && player <= 21) {
        std::cout << "Ganaste!" << std::endl;
    } else if (player == dealer) {
        std::cout << "Empate!" << std::endl;
    } else {
        std::cout << "Perdiste!" << std::endl;
    }
}

int main() {
    createDeck();
    initGame();
    checkWinner();
    return 0;
}
