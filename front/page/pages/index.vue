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
            <v-img :src="item.imagem"></v-img>
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
  background-color: rgb(255, 255, 255);
}
body {
    font-family: Arial, sans-serif;
    align-items: center;
    background-color: #f0f0f0;
    color: #333;

}
   .v-card{width: 400px;
  height: 450px;
  text-align: center;

  border-radius: 30px;
}
 .v-row{ margin-left: 150px;} 
v-col{ align-items: center;}
.v-row{ display: flex;align-items: center;;flex-direction: row;}
.v-img{

  border-radius: 20px;
  height: 55%;
}
</style>
