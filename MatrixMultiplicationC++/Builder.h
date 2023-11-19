#include <vector>

class MatrixMul{
public:
       class Builder{
       public:
              Builder();
              int n;
              std::vector<std::vector<double>> a;
              std::vector<std::vector<double>> b;
              std::vector<std::vector<double>> c;
    };
    
    std::vector<std::vector<double>>multiply(Operands operands);
    
};




