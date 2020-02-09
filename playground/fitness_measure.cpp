#include <iostream>

using namespace std;

int main()
{
    float tallness,weight,ratio,wtdifference;
    cout << "Please enter your tallness in cm \n";
    cin >> tallness;
    tallness/=100;
    cout << "Enter your weight in Kg \n";
    cin >> weight;
    ratio = weight / (tallness*tallness);
    if (ratio>25) {
        wtdifference = weight-25*tallness*tallness;
        cout << "You need to lose at least "<<wtdifference<<"Kg \n";
    }
        else if (ratio<18.5) {
        wtdifference = 18.5*tallness*tallness-weight;
        cout << "You need to gain at least "<<wtdifference<<"Kg \n";
        }
        else
            cout << "You are fit";

    return 0;
}
