package org.example.objectOrientedProgramming.introductionToInheritance

fun main() {
    val drill: Drill = Drill("1", "1", 1)
    val angleGrinder: AngleGrindel = AngleGrindel("1", "1", 1)
    val chainSaw: ChainSaw = ChainSaw("1", "1", 1)

    val powerTools: List<PowerTool> = listOf<PowerTool>(drill, angleGrinder, chainSaw)

        for(powerTool in powerTools){
            powerTool.turnOn()
        }
}