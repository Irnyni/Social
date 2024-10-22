<template>
  <div class="corpo">
   <!-- <pre>{{ items }}</pre>  Mostra o conteúdo bruto de items -->
    <!-- <h1>Lista de Itens</h1>
    <ul>
      <li v-for="item in items" :key="item.id">{{ item.titulo }}</li>
    </ul> -->
   <v-row>
    <v-col
          v-for="item in items"
          :key="item.id"
          
           
        >
          <v-card>
          

            <v-card-text style="font-size: 35px;">
              {{ item.titulo }}
              <v-card-text style="font-size: 20px;">
              {{ item.conteudo }}
            </v-card-text>
             
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
  </div>
</template> 

<script>
export default {
  data() {
    return {
      items: [],
    }
  },
  async mounted() {
  try {
    const response = await fetch('http://localhost:8077/Postagens');
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data = await response.json();
    this.items = data;
    console.log(this.items); // Adicione este log para verificar os dados
  } catch (error) {
    console.error('Erro ao buscar itens:', error);
  }
}

}
</script>

<style scoped>
.corpo{
display: flex;
  flex-direction: column;
  background-color: rgb(255, 255, 255);
  padding: 30px;
  width: 1900px;

  

  
  
 
}
    body{
      color:black
    }
   .v-card{width: 400px;
  height: 450px;
  text-align: center;
   
  

}
.v-row{ align-self: center;}
.v-col{ align-self: center;}
/* Adicione estilos aqui se necessário */
</style>
