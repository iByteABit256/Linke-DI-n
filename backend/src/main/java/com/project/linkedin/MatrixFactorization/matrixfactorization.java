package com.project.linkedin.MatrixFactorization;

import org.ejml.simple.SimpleMatrix;

public class matrixfactorization {
    public static SimpleMatrix mf(SimpleMatrix X, SimpleMatrix V, SimpleMatrix F, int K, int steps, double alpha, double beta){
        F = F.transpose();

        for(int step = 0; step < steps; step++){
            for(int i = 0; i < X.numRows(); i++){
                for(int j = 0; j < X.numCols(); j++){
                    if(X.get(i,j) > 0){

                       // Calculate error
                       double eij = X.get(i,j)-V.rows(i,i+1).dot(F.cols(j,j+1));

                       // Gradient descent step
                       for(int k = 0; k < K; k++){
                           V.set(i,k, V.get(i,k)+alpha*(2*eij*F.get(k,j)-beta*V.get(i,k)));
                           F.set(k,j, F.get(k,j)+alpha*(2*eij*V.get(i,k)-beta*F.get(k,j)));
                       }

                    }
                }
            }

            double e = 0;

            for(int i = 0; i < X.numRows(); i++){
                for(int j = 0; j < X.numCols(); j++){
                    if(X.get(i,j) > 0){
                        // Calculate error
                        double eij = X.get(i,j)-V.rows(i,i+1).dot(F.cols(j,j+1));

                        // Add error square to total error
                        e += eij*eij;

                        for(int k = 0; k < K; k++){
                            // Normalization
                            e += beta/2*V.get(i,k)*F.get(k,j);
                        }
                    }
                }
            }

            // End condition, unless it runs out of steps
            if(e < 0.001){
                break;
            }
        }
        return V.mult(F);
    }
}
