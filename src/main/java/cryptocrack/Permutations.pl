#!c:/strawberry/perl/bin/perl.exe

use strict;
use warnings;

my $MAX_FILE_SIZE = 1024 * 1024 * 1024; # 1 GB en bytes
my $file_count = 35;
my $current_file_size = 0;
my $file_name = "secuencia_$file_count.txt";

# Abrimos el primer archivo para escritura
#open(my $archivo, ">", $file_name) or die "No se puede abrir el archivo: $!";

# Iteramos sobre la secuencia y escribimos cada valor en el archivo correspondiente
foreach my $valor ("mfmueqq".."zzzzzzz") {
    my $longitud = length($valor);
    print "$valor\n";
    # $current_file_size = -s $archivo;
    # if ($current_file_size > $MAX_FILE_SIZE) {
    #     # Cerramos el archivo actual
    #     close($archivo);
    #     # Incrementamos el contador de archivos
    #     $file_count++;
    #     # Creamos un nuevo nombre de archivo
    #     $file_name = "secuencia_$file_count.txt";
    #     # Abrimos el nuevo archivo para escritura
    #     open($archivo, ">", $file_name) or die "No se puede abrir el archivo: $!";
    #     # Reiniciamos el tamaño del archivo actual
    #     $current_file_size = 0;
    # }
}

# Cerramos el archivo final
#close($archivo);