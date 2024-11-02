<template>
    <div class="formsss">
        <cab><h1>ADICIONAR VÍDEO</h1></cab>
        <v-sheet class="mx-auto" width="60%" >
    <v-form fast-fail @submit.prevent>
        <v-text-field
        v-model="Título"
        label="Título"
      ></v-text-field>
      <v-text-field
        v-model="Descrição"
        label="Descrição"
      ></v-text-field>

      <v-file-input prepend-icon="mdi-camera"  clearable label="Envie uma imagem de capa" variant="outlined"></v-file-input>
      <v-file-input  prepend-icon="mdi-video"  clearable label="Carregar video" variant="outlined"></v-file-input>
      <v-btn class="mt-12" type="submit"  block>Submit</v-btn>
    </v-form>
  </v-sheet>
    </div>
</template>

<script setup>

</script>

<style  scoped>
.mx-auto{
    margin: 80px;
    align-self: flex-start;

}
.v-input{
    margin: 30px;
    padding: 20px;
}
.mt-2 {
    width: 100px; /* Adjust this value to your preference */
}
</style>