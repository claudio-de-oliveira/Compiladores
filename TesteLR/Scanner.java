package Compiladores.TesteLR;

import Compiladores.CompilerBase.*;
import Compiladores.CompilerBase.LR.*;

public class Scanner extends AbsScanner {

    private int _currentPosition;

    public Scanner() {
        _currentPosition = 0;
    }

    @Override
    public AbstractToken nextToken(AbstractSymbolTable env, String text) {
        
        int state = 0;
        int integerPart = 0;
        double realPart = 0;
        double divisor = 10.0;

        if (_currentPosition >= text.length()) {
            return Token.EMPTY;
        }

        while (true) {

            switch(state) {
                case 0:
                    if (Character.isWhitespace(text.charAt(_currentPosition))) {
                        state = 0;
                        _currentPosition++;
                        break;
                    };
                    if (Character.isDigit(text.charAt(_currentPosition))) {
                        integerPart = text.charAt(_currentPosition) - '0';
                        state = 1;
                        _currentPosition++;
                        break;
                    };
                    if (text.charAt(_currentPosition) == '+') {
                        state = 5;
                        _currentPosition++;
                        break;
                    }
                    if (text.charAt(_currentPosition) == '-') {
                        state = 6;
                        _currentPosition++;
                        break;
                    }
                    if (text.charAt(_currentPosition) == '*') {
                        state = 7;
                        _currentPosition++;
                        break;
                    }
                    if (text.charAt(_currentPosition) == '/') {
                        state = 8;
                        _currentPosition++;
                        break;
                    }
                    if (text.charAt(_currentPosition) == '(') {
                        state = 9;
                        _currentPosition++;
                        break;
                    }
                    if (text.charAt(_currentPosition) == ')') {
                        state = 10;
                        _currentPosition++;
                        break;
                    }
                    if (text.charAt(_currentPosition) == '#') {
                        state = 11;
                        _currentPosition++;
                        break;
                    }
                    // outro: ERRO
                    state = 100;
                    _currentPosition++;
                    break;

                case 1:
                    if (Character.isDigit(text.charAt(_currentPosition))) {
                        integerPart = 10 * integerPart + text.charAt(_currentPosition) - '0';
                        state = 1;
                        _currentPosition++;
                        break;
                    };
                    if (text.charAt(_currentPosition) == '.') {
                        state = 2;
                        _currentPosition++;
                        break;
                    }
                    // outro: constante inteira
                    state = 4;
                    _currentPosition++;
                    break;

                case 2:
                    if (Character.isDigit(text.charAt(_currentPosition))) {
                        realPart = (text.charAt(_currentPosition) - '0') / divisor;
                        divisor = 10 * divisor;
                        state = 3;
                        _currentPosition++;
                        break;
                    };
                    // outro: ERRO
                    state = 100;
                    _currentPosition++;
                    break;

                case 3:
                    if (Character.isDigit(text.charAt(_currentPosition))) {
                        realPart = realPart + (text.charAt(_currentPosition) - '0') / divisor;
                        divisor = 10 * divisor;
                        state = 3;
                        _currentPosition++;
                        break;
                    };
                    // outro: constante real
                    state = 4;
                    _currentPosition++;
                    break;

                case 4:
                    _currentPosition--; // RETRACT
                    return new ConstantToken(integerPart + realPart);

                case 5:
                    return Token.ADD;
            
                case 6:
                    return Token.SUB;

                case 7:
                    return Token.MUL;
                    
                case 8:
                    return Token.DIV;
                    
                case 9:
                    return Token.LPAR;
                    
                case 10:
                    return Token.RPAR;
                    
                case 11:
                    return Token.ENDMARK;
                    
                case 100: // ERRO
                    _currentPosition--; // RETRACT
                    return new UnknowToken(text.charAt(_currentPosition));
            }
        }
    }
}